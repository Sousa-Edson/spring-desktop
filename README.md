

# NF-e Documentação

Este repositório contém uma representação simplificada da estrutura de um documento fiscal eletrônico (NF-e) em formato JSON, bem como um diagrama de classe correspondente.

## Arquivos

- `nf_e.json`: Este arquivo contém uma representação simplificada de um documento fiscal eletrônico em formato JSON.
- `diagrama_classe.png`: Uma imagem do diagrama de classe correspondente ao JSON.

## Estrutura do JSON

O arquivo `nf_e.json` contém um objeto `nfeProc`, que inclui os seguintes elementos:

- `NFe`: Contém informações relacionadas à Nota Fiscal Eletrônica.
- `protNFe`: Contém informações relacionadas ao protocolo da NF-e.

Cada elemento contém sub-elementos que representam diferentes seções do documento, como informações do emitente, destinatário, produtos, transporte, etc.

## Diagrama de Classe

O diagrama de classe representa graficamente a estrutura do documento fiscal eletrônico, incluindo suas diferentes seções e os atributos correspondentes.


```mermaid
classDiagram
  class nfeProc {
    +NFe
    +protNFe
  }
  class NFe {
    +infNFe
  }
  class infNFe {
    +ide
    +emit
    +dest
    +det
    +total
    +transp
    +infAdic
  }
  class emit {
    +CNPJ
    +xNome
    +enderEmit
    +IE
  }
  class enderEmit {
    +xLgr
    +nro
    +xBairro
    +cMun
    +xMun
    +UF
    +CEP
    +cPais
    +xPais
  }
  class dest {
    +CNPJ
    +xNome
    +enderDest
    +IE
  }
  class enderDest {
    +xLgr
    +nro
    +xBairro
    +cMun
    +xMun
    +UF
    +CEP
    +cPais
    +xPais
    +fone
  }
  class det {
    +prod
  }
  class prod {
    +cProd
    +xProd
    +NCM
    +CFOP
    +uCom
    +qCom
    +vUnCom
    +vProd
  }
  class total {
    +ICMSTot
  }
  class ICMSTot {
    +vNF
  }
  class transp {
    +modFrete
    +transporta
    +vol
  }
  class transporta {
    +CNPJ
    +xNome
    +IE
    +xEnder
    +xMun
    +UF
  }
  class vol {
    +qVol
    +esp
  }
  class infAdic {
    +infCpl
  }
  class protNFe {
    +infProt
  }
  class infProt {
    +chNFe
    +dhRecbto
    +xMotivo
  }

  nfeProc --> NFe
  nfeProc --> protNFe
  NFe --> infNFe
  infNFe --> ide
  infNFe --> emit
  infNFe --> dest
  infNFe --> det
  infNFe --> total
  infNFe --> transp
  infNFe --> infAdic
  emit --> enderEmit
  dest --> enderDest
  det --> prod
  total --> ICMSTot
  transp --> transporta
  transp --> vol
  protNFe --> infProt

```


 