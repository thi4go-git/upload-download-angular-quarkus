import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { LancamentoResponseDTO } from '../model/lancamentoResponseDTO';
import { ArquivoDownloaDTO } from '../model/arquivoDownloaDTO';


@Injectable({ providedIn: 'root' })
export class FileService {

  urlBackend: string = environment.apiUrl + '/lancamentos';

  constructor(private http: HttpClient) { }

  newLancamento(): Observable<LancamentoResponseDTO> {
    return this.http.post<LancamentoResponseDTO>(this.urlBackend + '/', new LancamentoResponseDTO());
  }


  uploadFile(formData: FormData, id: number): Observable<any> {
    return this.http.post(this.urlBackend + '/' + id + '/upload', formData, { responseType: 'blob' });
  }

  listAll(): Observable<LancamentoResponseDTO[]> {
    return this.http.get<LancamentoResponseDTO[]>(this.urlBackend + '/list');
  }

  downloadFile(id: number): Observable<ArquivoDownloaDTO> {
    return this.http.get<ArquivoDownloaDTO>(this.urlBackend + '/' + id + '/download');
  }

}
