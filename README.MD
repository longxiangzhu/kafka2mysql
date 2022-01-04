   	

# Kafka编程实战


**环境依赖**
```
1.Java：1.8
2.Maven：3.6
3.spring-Boot：2.5.3
4.spring-kafka:2.7.2
5.spring-data-jpa:2.6.2
6.apache kafka-clients:2.7.1
7.mysql-connector-java:8.0.22
```    
           
           
## 实验目的
**用一个接口把产品相关数据发送Kafka的某一个主题中，然后再创建一个Kafka消费者将消息消费保存到MySQL的product表中**

1. 创建Spring Maven项目
2. 创建实体类product
3. 创建Producer配置类
4. 创建Producer Service 
5. 创建Producer Controller
6. 创建Consumer 配置类
7. 创建Consumer 监听服务
8. 部署服务
9. 测试

**测试命令**
```
    curl -X POST http://172.18.1.150:8088/prod/insert -H 'Content-Type: application/json'  -d '{
        "id":100,
        "prodCode":"PUxxxx0006",
        "prodName":"pxxx06",
        "prodUnit":"PUxxxx0006"
    }'

```
**测试结果截图**

![image](https://user-images.githubusercontent.com/28383569/148025528-63efc057-3948-4775-9dba-28c33e23ea2b.png)

![image](https://user-images.githubusercontent.com/28383569/148025467-fde530b7-1d38-4205-8f14-5f8e3903bca6.png)


![企业微信截图_16412820267729](https://user-images.githubusercontent.com/28383569/148025369-f682abd6-faaf-444f-8c5d-6aed24c607dd.png)
