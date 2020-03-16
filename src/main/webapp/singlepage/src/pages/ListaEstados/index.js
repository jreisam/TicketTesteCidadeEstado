import React from 'react';

class ListaEstados extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <tr>
                <td>{this.props.nome}</td>
                <td>{this.props.sigla}</td>
                <td>{this.props.populacao}</td>
                <td>{this.props.nCidades}</td>
                {/*     <td>
                    <button className="btn btn-danger" onClick={this.deleteBcMsg}>Delete</button>
                </td>*/}
            </tr>
        );
    }
}

export default ListaEstados;