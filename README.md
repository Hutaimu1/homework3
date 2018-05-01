# homework3
一开始提交整个文件就是提交不了，我也不知道什么原因，这里只提交了几个.java文件。。。。
run demo7application;
访问localhost:8080/WordLadder
会提示Full authentication is required to access this resourceunauthorized
然后访问localhost:8080/oauth/token?grant_type=client_credentials&scope=select&client_id=client_1&client_secret=123456
会显示access_token如下：
{"access_token":"aacd7366-0631-4a67-9b1f-e45ca7aa6770","token_type":"bearer","expires_in":43199,"scope":"select"}
接着访问localhost:8080/WordLadder?access_token=aacd7366-0631-4a67-9b1f-e45ca7aa6770&begin=word1&end=word2输出结果
