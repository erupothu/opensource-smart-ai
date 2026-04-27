import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export interface AiRequest {
  prompt: string;
  // optional conversation/context id
  conversationId?: string;
}

@Injectable({ providedIn: 'root' })
export class AiService {
  private base = environment.aiEndpoint;

  constructor(private http: HttpClient) {}

  /**
   * Send prompt to backend AI endpoint. Backend should proxy to OpenAI or other provider
   * and return a JSON response.
   */
  chat(request: AiRequest): Observable<any> {
    return this.http.post<any>(`${this.base}/chat`, request);
  }
}
