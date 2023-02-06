export interface Lancamento {
  code: number;
  tipo: string;
  local: string;
  descricao: string;
  dataDaCompra: Date;
  dataDeVencimento: Date;
  valor: number;
}
