# db-trade-app

API endpoints exposed are
  1. POST /tradebook/add and JSON body as request.
      - JSON body format is {"tradeId": "T3","version": 4,"counterPartyId": "CP-3","bookId": "B3","maturityDate": "20-05-2021"}
  2. GET /tradebook/tradeId/{tradeId}/version/{version}
  
