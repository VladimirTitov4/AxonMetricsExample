# AxonMetricsExample

1. docker-compose up
2. run the spring boot application
3. go to prometheus localhost:9090/targets check that axon-application &  axon-server are having state up
4. check metrics for axon server http://localhost:8024/actuator/prometheus (there must be some axon metrics) 
5. check metrics for axon application http://localhost:8080/actuator/prometheus (there are NO axon metrics, just basic metrics from jvm) 
4. go to grafana localhost:3000, add datasource, go to dash boards, import axon-server dashboard (grafana id: 12962) - that dashboard should work well, 
but if import axon-framework dashboard (grafana id: 12963) there will be NO AXON METRICS
