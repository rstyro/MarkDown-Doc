/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : doc

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-10-10 09:49:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc_api
-- ----------------------------
DROP TABLE IF EXISTS `doc_api`;
CREATE TABLE `doc_api` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `level` tinyint(5) DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `content` text,
  `user_id` int(11) DEFAULT NULL,
  `is_del` varchar(1) DEFAULT '0' COMMENT '是否删除',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of doc_api
-- ----------------------------
INSERT INTO `doc_api` VALUES ('1', '0', '1', 'MarkDown 使用手册', null, '2', '0', '2018-10-10 09:49:01', '2018-07-26 14:55:41');
INSERT INTO `doc_api` VALUES ('2', '1', '0', 'MarkDown 使用示例', '# 编辑这个，通过对比两个视图，可以知道markdown 语法的使用\r\n\r\n\r\n\r\n# Heading 1\r\n## Heading 2               \r\n### Heading 3\r\n#### Heading 4\r\n##### Heading 5\r\n###### Heading 6\r\n# Heading 1 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\r\n## Heading 2 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\r\n### Heading 3 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\r\n#### Heading 4 link [Heading link](https://github.com/pandao/editor.md \"Heading link\") Heading link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\r\n##### Heading 5 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\r\n###### Heading 6 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\r\n\r\n#### 标题（用底线的形式）Heading (underline)\r\n\r\nThis is an H1\r\n=============\r\n\r\nThis is an H2\r\n-------------\r\n\r\n### 字符效果和横线等\r\n                \r\n----\r\n\r\n~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\r\n*斜体字*      _斜体字_\r\n**粗体**  __粗体__\r\n***粗斜体*** ___粗斜体___\r\n\r\n上标：X<sub>2</sub>，下标：O<sup>2</sup>\r\n\r\n**缩写(同HTML的abbr标签)**\r\n\r\n> 即更长的单词或短语的缩写形式，前提是开启识别HTML标签时，已默认开启\r\n\r\nThe <abbr title=\"Hyper Text Markup Language\">HTML</abbr> specification is maintained by the <abbr title=\"World Wide Web Consortium\">W3C</abbr>.\r\n\r\n### 引用 Blockquotes\r\n\r\n> 引用文本 Blockquotes\r\n\r\n引用的行内混合 Blockquotes\r\n                    \r\n> 引用：如果想要插入空白换行`即<br />标签`，在插入处先键入两个以上的空格然后回车即可，[普通链接](http://localhost/)。\r\n\r\n### 锚点与链接 Links\r\n\r\n[普通链接](http://localhost/)\r\n\r\n[普通链接带标题](http://localhost/ \"普通链接带标题\")\r\n\r\n直接链接：<https://github.com>\r\n\r\n[锚点链接][anchor-id] \r\n\r\n[anchor-id]: http://www.this-anchor-link.com/\r\n\r\n[mailto:test.test@gmail.com](mailto:test.test@gmail.com)\r\n\r\nGFM a-tail link @pandao  邮箱地址自动链接 test.test@gmail.com  www@vip.qq.com\r\n\r\n> @pandao\r\n\r\n### 多语言代码高亮 Codes\r\n\r\n#### 行内代码 Inline code\r\n\r\n执行命令：`npm install marked`\r\n\r\n#### 缩进风格\r\n\r\n即缩进四个空格，也做为实现类似 `<pre>` 预格式化文本 ( Preformatted Text ) 的功能。\r\n\r\n    <?php\r\n        echo \"Hello world!\";\r\n    ?>\r\n    \r\n预格式化文本：\r\n\r\n    | First Header  | Second Header |\r\n    | ------------- | ------------- |\r\n    | Content Cell  | Content Cell  |\r\n    | Content Cell  | Content Cell  |\r\n\r\n#### JS代码　\r\n\r\n```javascript\r\nfunction test() {\r\n	console.log(\"Hello world!\");\r\n}\r\n \r\n(function(){\r\n    var box = function() {\r\n        return box.fn.init();\r\n    };\r\n\r\n    box.prototype = box.fn = {\r\n        init : function(){\r\n            console.log(\'box.init()\');\r\n\r\n			return this;\r\n        },\r\n\r\n		add : function(str) {\r\n			alert(\"add\", str);\r\n\r\n			return this;\r\n		},\r\n\r\n		remove : function(str) {\r\n			alert(\"remove\", str);\r\n\r\n			return this;\r\n		}\r\n    };\r\n    \r\n    box.fn.init.prototype = box.fn;\r\n    \r\n    window.box =box;\r\n})();\r\n\r\nvar testBox = box();\r\ntestBox.add(\"jQuery\").remove(\"jQuery\");\r\n```\r\n\r\n#### HTML 代码 HTML codes\r\n\r\n```html\r\n<!DOCTYPE html>\r\n<html>\r\n    <head>\r\n        <mate charest=\"utf-8\" />\r\n        <meta name=\"keywords\" content=\"Editor.md, Markdown, Editor\" />\r\n        <title>Hello world!</title>\r\n        <style type=\"text/css\">\r\n            body{font-size:14px;color:#444;font-family: \"Microsoft Yahei\", Tahoma, \"Hiragino Sans GB\", Arial;background:#fff;}\r\n            ul{list-style: none;}\r\n            img{border:none;vertical-align: middle;}\r\n        </style>\r\n    </head>\r\n    <body>\r\n        <h1 class=\"text-xxl\">Hello world!</h1>\r\n        <p class=\"text-green\">Plain text</p>\r\n    </body>\r\n</html>\r\n```\r\n\r\n### 图片 Images\r\n\r\nImage:\r\n\r\n![](https://pandao.github.io/editor.md/examples/images/4.jpg)\r\n\r\n> Follow your heart.\r\n\r\n![](https://pandao.github.io/editor.md/examples/images/8.jpg)\r\n\r\n> 图为：厦门白城沙滩\r\n\r\n图片加链接 (Image + Link)：\r\n\r\n[![](http://lrshuai.top/images/me.jpg)](http://lrshuai.top/images/me.jpg \"最帅的大叔\")\r\n\r\n> 图为：帅大叔的头像\r\n                \r\n----\r\n### 列表 Lists\r\n\r\n#### 无序列表（减号）Unordered Lists (-)\r\n                \r\n- 列表一\r\n- 列表二\r\n- 列表三\r\n     \r\n#### 无序列表（星号）Unordered Lists (*)\r\n\r\n* 列表一\r\n* 列表二\r\n* 列表三\r\n\r\n#### 无序列表（加号和嵌套）Unordered Lists (+)\r\n                \r\n+ 列表一\r\n+ 列表二\r\n    + 列表二-1\r\n    + 列表二-2\r\n    + 列表二-3\r\n+ 列表三\r\n    * 列表一\r\n    * 列表二\r\n    * 列表三\r\n\r\n#### 有序列表 Ordered Lists (-)\r\n                \r\n1. 第一行\r\n2. 第二行\r\n3. 第三行\r\n\r\n#### GFM task list\r\n\r\n- [x] GFM task list 1\r\n- [x] GFM task list 2\r\n- [ ] GFM task list 3\r\n    - [ ] GFM task list 3-1\r\n    - [ ] GFM task list 3-2\r\n    - [ ] GFM task list 3-3\r\n- [ ] GFM task list 4\r\n    - [ ] GFM task list 4-1\r\n    - [ ] GFM task list 4-2\r\n                \r\n----\r\n                    \r\n### 绘制表格 Tables\r\n\r\n| 项目        | 价格   |  数量  |\r\n| --------   | -----:  | :----:  |\r\n| 计算机      | $1600   |   5     |\r\n| 手机        |   $12   |   12   |\r\n| 管线        |    $1    |  234  |\r\n                    \r\nFirst Header  | Second Header\r\n------------- | -------------\r\nContent Cell  | Content Cell\r\nContent Cell  | Content Cell \r\n\r\n| First Header  | Second Header |\r\n| ------------- | ------------- |\r\n| Content Cell  | Content Cell  |\r\n| Content Cell  | Content Cell  |\r\n\r\n| Function name | Description                    |\r\n| ------------- | ------------------------------ |\r\n| `help()`      | Display the help window.       |\r\n| `destroy()`   | **Destroy your computer!**     |\r\n\r\n| Left-Aligned  | Center Aligned  | Right Aligned |\r\n| :------------ |:---------------:| -----:|\r\n| col 3 is      | some wordy text | $1600 |\r\n| col 2 is      | centered        |   $12 |\r\n| zebra stripes | are neat        |    $1 |\r\n\r\n| Item      | Value |\r\n| --------- | -----:|\r\n| Computer  | $1600 |\r\n| Phone     |   $12 |\r\n| Pipe      |    $1 |\r\n                \r\n----\r\n\r\n#### 特殊符号 HTML Entities Codes\r\n\r\n&copy; &  &uml; &trade; &iexcl; &pound;\r\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot; \r\n\r\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\r\n\r\n18&ordm;C  &quot;  &apos;\r\n\r\n[========]\r\n#### 反斜杠 Escape\r\n\r\n\\*literal asterisks\\*\r\n\r\n[========]\r\n            \r\n### 科学公式 TeX(KaTeX)\r\n\r\n$$E=mc^2$$\r\n\r\n行内的公式$$E=mc^2$$行内的公式，行内的$$E=mc^2$$公式。\r\n\r\n$$x > y$$\r\n\r\n$$\\(\\sqrt{3x-1}+(1+x)^2\\)$$\r\n                    \r\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\r\n\r\n多行公式：\r\n\r\n```math\r\n\\displaystyle\r\n\\left( \\sum\\_{k=1}^n a\\_k b\\_k \\right)^2\r\n\\leq\r\n\\left( \\sum\\_{k=1}^n a\\_k^2 \\right)\r\n\\left( \\sum\\_{k=1}^n b\\_k^2 \\right)\r\n```\r\n\r\n```katex\r\n\\displaystyle \r\n    \\frac{1}{\r\n        \\Bigl(\\sqrt{\\phi \\sqrt{5}}-\\phi\\Bigr) e^{\r\n        \\frac25 \\pi}} = 1+\\frac{e^{-2\\pi}} {1+\\frac{e^{-4\\pi}} {\r\n        1+\\frac{e^{-6\\pi}}\r\n        {1+\\frac{e^{-8\\pi}}\r\n         {1+\\cdots} }\r\n        } \r\n    }\r\n```\r\n\r\n```latex\r\nf(x) = \\int_{-\\infty}^\\infty\r\n    \\hat f(\\xi)\\,e^{2 \\pi i \\xi x}\r\n    \\,d\\xi\r\n```\r\n\r\n### 分页符 Page break\r\n\r\n> Print Test: Ctrl + P\r\n\r\n[========]\r\n### 绘制流程图 Flowchart\r\n\r\n```flow\r\nst=>start: 用户登陆\r\nop=>operation: 登陆操作\r\ncond=>condition: 登陆成功 Yes or No?\r\ne=>end: 进入后台\r\n\r\nst->op->cond\r\ncond(yes)->e\r\ncond(no)->op\r\n```\r\n\r\n[========]\r\n\r\n\r\n', '2', '0', '2018-10-10 09:49:03', '2018-07-26 14:56:02');

-- ----------------------------
-- Table structure for doc_user
-- ----------------------------
DROP TABLE IF EXISTS `doc_user`;
CREATE TABLE `doc_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `lock` enum('0','1') DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of doc_user
-- ----------------------------
INSERT INTO `doc_user` VALUES ('1', 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', '管理员', '0', '2018-07-16 16:33:51');
INSERT INTO `doc_user` VALUES ('2', 'rstyro', '86f7e437faa5a7fce15d1ddcb9eaeaea377667b8', '开发', '0', '2018-07-20 12:54:26');
