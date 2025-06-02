export interface Credito {
  numeroCredito: string;
  numeroNfse: string;
  dataConstituicao: string; // ISO String
  valorIssqn: number;
  tipoCredito: string;
  simplesNacional: boolean;
  aliquota: number;
  valorFaturado: number;
  valorDeducao: number;
  baseCalculo: number;
}