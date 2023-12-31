import { Component, OnInit } from '@angular/core';
import { LancamentoResponseDTO } from 'src/app/model/lancamentoResponseDTO';
import { FileService } from 'src/app/services/file.service';
import { MatTableDataSource } from '@angular/material/table';
import { Buffer } from 'buffer';
import { ArquivoDownloaDTO } from 'src/app/model/arquivoDownloaDTO';



@Component({
  selector: 'app-conteudo',
  templateUrl: './conteudo.component.html',
  styleUrls: ['./conteudo.component.css']
})
export class ConteudoComponent implements OnInit {

  constructor(private fileService: FileService) { }

  displayedColumns: string[] = ['id', 'protocolo', 'dataLancamento', 'nomeArquivo', 'download'];
  lancamentos: LancamentoResponseDTO[] = [];
  dataSource: MatTableDataSource<LancamentoResponseDTO> = new MatTableDataSource;

  ngOnInit(): void {
    this.carregarLista();
  }


  novoLancamento() {
    this.fileService.newLancamento()
      .subscribe({
        next: (_resposta) => {
          this.carregarLista();
        },
        error: (responseError) => {
          console.log(responseError);
          alert("Erro ao Salvar")
        }
      });
  }


  uploadFile(event: any, id: number) {
    const files = event.target.files;
    if (files) {
      const arquivo: File = files[0];
      const formData: FormData = new FormData();
      formData.append("arquivo", arquivo);
      formData.append("nome", arquivo.name);
      formData.append("type", arquivo.type);
      this.upload(formData, id);
    } else {
      alert("Selecione um arquivo")
    }
  }


  private carregarLista() {
    this.fileService.listAll()
      .subscribe({
        next: (resposta) => {
          this.lancamentos = resposta;
          this.dataSource = new MatTableDataSource(this.lancamentos);
        },
        error: (responseError) => {
          console.log(responseError);
          alert("Erro ao Obter Listagem")
        }
      });
  }

  private upload(formData: FormData, id: number) {
    this.fileService.uploadFile(formData, id)
      .subscribe({
        next: (_resposta) => {
          alert("Sucesso UPLOAD")
          this.carregarLista();
        },
        error: (responseError) => {
          console.log(responseError);
          alert("Erro upload.")
        }
      });
  }



  baixar(id: number) {
    this.fileService.downloadFile(id)
      .subscribe({
        next: (resposta) => {
          const sampleArr = this.base64ToArrayBufferAngular16(resposta.arquivo);
          this.saveByteArray(resposta, sampleArr);
        },
        error: (responseError) => {
          console.log(responseError);
          alert("Erro ao Obter Arquivo do banco de dados!")
        }
      });
  }


  private base64ToArrayBufferAngular15(base64: any) {
    //(window.atob) Só funciona até angular 15 conforme MDN Reference
    // window.btoa('test')  faz o encode: ('test' > dGVzdA== )
    // window.atob('dGVzdA==') faz o decode: ('dGVzdA==' > test )
    var binaryString = window.atob(base64);
    var binaryLen = binaryString.length;
    var bytes = new Uint8Array(binaryLen);
    for (var i = 0; i < binaryLen; i++) {
      var ascii = binaryString.charCodeAt(i);
      bytes[i] = ascii;
    }
    return bytes;
  }


  private base64ToArrayBufferAngular16(base64: any) {
    // instalar a dep:  npm i buffer && npm install --save-dev @types/node 
    // configurar o types node no tsconfig.json  "types": [   "node",] (Dentro de compilerOptions )
    // Usar o: import { Buffer } from 'buffer';
    //(Buffer.from) Usar do angular 16 adiante.
    if (base64) {
      var binaryString = Buffer.from(base64, 'base64');
      var bytes = new Uint8Array(binaryString.length);
      for (var i = 0; i < binaryString.length; i++) {
        bytes[i] = binaryString[i];
      }
      return bytes;
    } else {
      console.error("base64 está indefinido ou vazio");
      return null;
    }
  }

  private saveByteArray(arquivo: ArquivoDownloaDTO, byte: any) {
    var blob = new Blob([byte], { type: arquivo.typeArquivo });
    var link = document.createElement('a');
    link.href = window.URL.createObjectURL(blob);
    var fileName = arquivo.nomeArquivo;
    link.download = fileName;
    link.click();
  }


}
