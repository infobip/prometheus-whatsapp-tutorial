
# Integrate Prometheus with Infobip WhatsApp API


## About

(Tutorial is available at <INSERT_LINK>)

This project illustrates how to integrate Prometheus with Infobip's WhatsApp API in order to receive alerts on a mobile
phone. 


## Setup

You will need an account on Infobip and a WhatsApp API key with the scope `whatsapp:message:send`, before running the 
application make sure to replace the placeholders in `application.properties` file with your:

- Infobip API key
- personal Infobip base url
- sender phone number
- recipient phone number

(all of the values except recipient phone number can be found in your Infobip account)

To run the local monitoring setup, run the following command from project root directory:

```shell
docker compose up -d
```

This will start a Prometheus and Alertmanager instance on your local machine. You can access the Prometheus dashboard
at `localhost:9090` and the Alertmanager dashboard at `localhost:9093`. 

To run the application, execute the following command from the project root directory:

```shell
mvn spring-boot:run
```

This will create a following setup, which will send a message to your phone number after the application starts:

![Monitoring Setup](monitoring_setup.png)

To shut down the monitoring setup, run the following command from the project root directory:

```shell
docker compose down
```

