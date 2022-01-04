   	

#                                           Kafka编程实战


     
        
           
           
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
