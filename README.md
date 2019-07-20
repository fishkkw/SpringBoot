# SpringBoot+redis
1、自定义generator
	1.1 提取mapper.java父类。
	1.2 根据mgb生成modil类，考虑是否是否需要生成辅助类。
		已处理单个主键，复合主键。待处理联合主键，没有主键的的情况。
2、整合redis
	2.1 修改redis序列化方式，处理热部署下不同的类加载器导致redis类型转换异常
3、使用logback记录日志，并进行全局日志处理
	3.1 日志安全，过滤日志中/r、/n、/t
	3.2敏感信息处理：例：日志输入：电话信息（1300909090==》130****9090）
4、登录认证
	4.1 待处理
5、poi导出
	5.1 单sheet导出，超过300000分表
	5.2多sheet导出，每页不超过限定数
6、网络安全
	6.1 防止xss攻击
	6.2跨域伪造攻击 待处理
	6.3 
	