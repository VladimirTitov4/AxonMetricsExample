# AxonMetricsExample

1. docker-compose up
2. run the spring boot application
3. go to prometheus localhost:9090/targets check that axon-application &  axon-server are having state up
4. go to grafana localhost:3000, add datasource, go to dash boards, import axon-server dashboard (grafana id: 12962) - that dashboard should work well, 
but as for axon-framework dashboard (grafana id: 12963) there will be empty axon metrics
