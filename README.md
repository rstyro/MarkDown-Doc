# MarkDown-Doc
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
