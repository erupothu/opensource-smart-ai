import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { AiService } from '../../services/ai.service';

interface Message { role: 'user'|'assistant'|'system'; text: string }

@Component({
  selector: 'app-chat-widget',
  standalone: true,
  imports: [CommonModule, FormsModule, MatIconModule, MatButtonModule, MatCardModule, MatInputModule, MatListModule],
  templateUrl: './chat-widget.component.html',
  styleUrls: ['./chat-widget.component.scss']
})
export class ChatWidgetComponent {
  open = false;
  input = '';
  loading = false;
  messages: Message[] = [];

  constructor(private ai: AiService) {}

  toggle() { this.open = !this.open; }

  send() {
    const prompt = this.input?.trim();
    if (!prompt) return;
    const userMsg: Message = { role: 'user', text: prompt };
    this.messages.push(userMsg);
    this.input = '';
    this.loading = true;

    this.ai.chat({ prompt }).subscribe({
      next: res => {
        // Expect backend to return { reply: 'text' } or raw JSON - push readable text when available
        const text = typeof res === 'string' ? res : (res?.reply ?? JSON.stringify(res));
        this.messages.push({ role: 'assistant', text });
        this.loading = false;
      },
      error: err => {
        this.messages.push({ role: 'assistant', text: 'Error: could not reach AI backend.' });
        this.loading = false;
      }
    });
  }
}
