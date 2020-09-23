# Custumer Service

### Requisitos

1. JDK 8
1. Maven 3

### Rodando

1. Clone o projeto: `https://github.com/RudsonCarriel/Teste---Tokio.git`
1. Acesse: `http://localhost:8080/customers/cliente/`
1.Json POST
[
    {
        "name": "Rudson",
        "email": "rudson@email.com"
    },
    {
        "name": "Arthur",
        "email": "arthur@email.com"
    },
    {
        "name": "David",
        "email": "David@email.com"
    }
]

1.Json PUT
[
    {
        "id": 1,
        "name": "Marcelo",
        "email": "marcelo@email.com"
    },
    {
        "id": 2,
        "name": "Josia",
        "email": "josia@email.com"
    },
    {
        "id": 3,
        "name": "Maria",
        "email": "mariav@email.com"
    }
]

2. Acesse:`http://localhost:8080/address/endereco/` 
2.Json: POST
[
    {
        "cep": "06016030",
        "customer_id": 1,
        "complemento_end": "AP 53",
        "numero": 133471
    },
    {
        "cep": "03132080",
        "customer_id": 1,
        "complemento_end": "BLOCO A",
        "numero": 12331
    },
     {
        "cep": "3150020",
        "customer_id": 6,
        "complemento_end": "AP 54 BLOCO C",
        "numero": 333
    }
]



