import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ArquivoResponseDTO } from '../model/arquivoResponseDTO';
import { environment } from '../environments/environment';
import { ArquivoDownloadDTO } from '../model/arquivoDownloadDTO';


@Injectable({ providedIn: 'root' })
export class FileService {

  urlBackend: string = environment.apiUrl + '/file';

  constructor(private http: HttpClient) { }

  uploadFile(formData: FormData): Observable<any> {
    return this.http.post(this.urlBackend + '/upload', formData, { responseType: 'blob' });
  }

  getAll(): Observable<ArquivoResponseDTO[]> {
    return this.http.get<ArquivoResponseDTO[]>(this.urlBackend + '/list');
  }

  downloadFile(id: number): Observable<ArquivoDownloadDTO> {
    return this.http.get<ArquivoDownloadDTO>(this.urlBackend + '/' + id);
  }

}
