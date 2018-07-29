# MarkDown-Doc
### 看名字就知道，这个是一个MarkDown 语法的接口文档
### 使用方法：
+ 1、创建一个数据库并倒入sql脚本：doc.sql
+ 2、修改 Application.class 中的 `IS_AUTH` 改为`false`(意思就是不用登录也可以看文档，true -- 则需要登录才可观看文档)
+ 3、用户：admin，密码：admin
## 示例图如下：
![https://github.com/rstyro/MarkDown-Doc/blob/master/img/api.png](https://github.com/rstyro/MarkDown-Doc/blob/master/img/api.png)
![https://github.com/rstyro/MarkDown-Doc/blob/master/img/apitest.png](https://github.com/rstyro/MarkDown-Doc/blob/master/img/apitest.png)

### 接口测试那里还有点小问题，就是接口会有跨域问题。如果后端有跨域设置，才能访问。比如：
```
this.response.addHeader("Access-Control-Allow-Origin", "*");
this.response.addHeader("Access-Control-Allow-Methods", "get, post, put, delete, options");
this.response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept");
this.response.addHeader("Access-Control-Allow-Credentials", "true");
```
### 接口模板可以自己设置:model.txt
