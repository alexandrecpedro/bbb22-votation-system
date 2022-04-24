import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Participante } from '../model/participante';
import { RestService } from '../service/RestService';

@Component({
  selector: 'app-registrar-votacao',
  templateUrl: './registrar-votacao.component.html',
  styleUrls: ['./registrar-votacao.component.css']
})
export class RegistrarVotacaoComponent implements OnInit {

  // Attributes
  title = 'Voto registrado';
  voto = '';

  constructor(private route: ActivatedRoute,
    private restService: RestService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.enviarVoto(params['id'])
    });
  }

  // Method
  enviarVoto(id: string) {
    let request = { id: id }
    this.restService.postData('/votacao', request).subscribe(response => {
      console.log(response);
      if (response.nome.trim() == '' || response.nome == null) {
        switch (response.id()) {
          case "62659fb50532f82ad4bd8b3f":
            response.nome = "Jessilane";
            break;
          case "62659fbf0532f82ad4bd8b40":
            response.nome = "Laís";
            break;
          case "62659fcd0532f82ad4bd8b41":
            response.nome = "Eliezer";
            break;
          case "62659fd30532f82ad4bd8b42":
            response.nome = "PA";
            break;
          case "62659fda0532f82ad4bd8b43":
            response.nome = "Jade Picon";
            break;
          case "62659fe40532f82ad4bd8b44":
            response.nome = "Arthur Aguiar";
            break;
          default:
            response.nome = "Tarciana";
        }
      }
      let voto = response as Participante;
      this.voto = voto.nome;
    });
  }
}
