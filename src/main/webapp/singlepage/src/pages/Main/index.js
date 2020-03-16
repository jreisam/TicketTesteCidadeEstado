import React from 'react';
import bandeiraPN from '../../images/bandeiraPN.PNG';
import bandeiraRS from '../../images/bandeiraRS.PNG';
import bandeiraSC from '../../images/bandeiraSC.PNG';
import ListaEstados from '../ListaEstados/index';
import Alert from "react-bootstrap/Alert";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";

class Main extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            dolarHoje: 0,
            uf: 'sc',
            nome: '',
            populacao: 0,
            estados: [],
            ncidades: 0,
            bandeiras: [
                {
                    id: 0,
                    img: bandeiraRS
                },
                {
                    id: 1,
                    img: bandeiraSC
                },
                {
                    id: 2,
                    img: bandeiraPN
                }
            ],
            bandeirasSelected: 1
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChangeFieldNome = this.handleChangeFieldNome.bind(this);
        this.handleChangeFieldPopulacao = this.handleChangeFieldPopulacao.bind(this);

    }


    componentDidMount() {
        this.loadEstadosFromServer();
        this.loadCurrencyFromApi();
    }

    loadEstadosFromServer() {
        fetch('http://localhost:8080/estado')
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    estados: responseData
                });
            });
    }

    loadCurrencyFromApi() {
        fetch('https://free.currconv.com/api/v7/convert?q=USD_BRL&compact=ultra&apiKey=bde9b3734a2d57693731')
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    dolarHoje: responseData,
                });
            });
    }

    handleChange(event) {
        this.setState({
            uf: event.target.value,
            bandeirasSelected: event.target.options.selectedIndex
        });
    }

    handleChangeFieldNome(event) {
        this.setState({nome: event.target.value});
    }

    handleChangeFieldPopulacao(event) {
        this.setState({populacao: event.target.value});
    }

    handleSubmit = event => {
        event.preventDefault();
        console.log(this.state);
        const url = "http://localhost:8080/cidade/porUF/" + this.state.uf;
        const data = {nome: this.state.nome, populacao: this.state.populacao}
        fetch(url, {
            method: 'POST',
            body: JSON.stringify(data),
            headers:
                {'Content-Type': 'application/json'}
        }).then(response => console.log('recebido:', response)).then(() => window.location.reload());
    }

    render() {
        console.log(this.state.estados);
        console.log(this.state.dolarHoje);
        if (this.state.estados != null) {
            var estados = this.state.estados.map(estado =>

                <ListaEstados key={estado.id} nome={estado.nome} sigla={estado.sigla} populacao={estado.populacao}
                              nCidades={estado.nCidades}/>
            );
        }
        return (
            <div>
                <div className="card" style={{width: 18 + 'rem', margin: 15 + 'px'}}>

                    <img className="card-img-top" src={this.state.bandeiras[this.state.bandeirasSelected]["img"]}
                         width="100" height="100"/>
                </div>
                <Alert variant='primary' style={{margin: 15 + 'px'}}>
                    Dólar Hoje: {this.state.dolarHoje.USD_BRL}
                </Alert>
                <div className="card" style={{margin: 15 + 'px'}}>
                    <div className="card-header">
                        Informar dados populacionais
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">Cidade</h5>
                        <p className="card-text"></p>

                        <Form onSubmit={this.handleSubmit}>
                            <Form.Row>
                                <Form.Group as={Col} controlId="nome">
                                    <Form.Label>Nome</Form.Label>
                                    <Form.Control placeholder="Informe o nome da Cidade"
                                                  onChange={this.handleChangeFieldNome}/>
                                </Form.Group>
                                <Form.Group as={Col} controlId="uf">
                                    <Form.Label>Estado</Form.Label>
                                    <Form.Control as="select" value={this.state.uf} onChange={this.handleChange}>
                                        <option value="rs">Rio Grande do Sul</option>
                                        <option value="sc">Santa Catarina</option>
                                        <option value="pn">Paraná</option>
                                    </Form.Control>
                                </Form.Group>
                                <Form.Group as={Col} controlId="populacao">
                                    <Form.Label>População</Form.Label>
                                    <Form.Control placeholder="100" onChange={this.handleChangeFieldPopulacao}/>
                                </Form.Group>
                            </Form.Row>
                            <Button variant="primary" type="submit">
                                Salvar
                            </Button>
                        </Form>
                    </div>
                </div>


                <table className="table table-striped" style={{margin: 20 + 'px'}}>
                    <thead>
                    <tr>
                        <th>Estado</th>
                        <th>Sigla</th>
                        <th>População</th>
                        <th>N. Cidades</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>{estados}</tbody>
                </table>
            </div>
        );
    }
}

export default Main;
