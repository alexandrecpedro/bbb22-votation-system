import { Component, OnInit } from '@angular/core';
import { Participante } from '../model/participante';
import { RestService } from '../service/RestService';

@Component({
  selector: 'app-votacao',
  templateUrl: './votacao.component.html',
  styleUrls: ['./votacao.component.css']
})
// OnInit = inicializar alguma variável
export class VotacaoComponent implements OnInit {

  // Attributes
  participantes: Participante[] | undefined;
  title = 'Votação BBB 22';

  // Constructor
  constructor(private restService : RestService) { }

  ngOnInit(): void {
    this.getParticipantes();
  }

  // Methods
  getParticipantes() {
    this.restService.getData('/participantes/todos').subscribe((participantes) => {
      this.participantes = participantes;
    });
  }
}
