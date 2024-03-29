package com.huixin.framework.utils.ali.pay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
//	public static String partner = "2088321047262007";//haidong
									
	/***
	 * 健康班车 */  
	
	// 商户的私钥,使用支付宝自带的openssl工具生成。
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOXHAxq7P7tFy6YDQX1xIRJfNHMy3tf77ji9b+NAZ8aEHHu5U8rGj3C+uEwX5JT9R4uUbayiqrklt7kylMMJMPY6QMDp7BwzIp8OG/g3puYAJr0ugBd5nIZ5uVzu90TLK3byGMGi3a58vjvECf4uucYnA9EtgalXuiUXGZE0ZeNNAgMBAAECgYBsVYdGLDChKAgbLn/LF/KCyfZdtgdRB8vKXq6JE42aECGpx7gU68cnXhRgdAdmo3/+9C09brhVcM4NeCahSg0VtZHkeexpN3IbtA/2uDtjp6NYSsGSoXbraPkhmssuwd4MsLBG6unRLtlvvFhLaMhsBAyALttW37gcXDhx2OgGwQJBAPptNo/3ICK/+bZaUFKdZNMaoFFGlb6+giMIYO+Y9ROVzPViTd5igGHvFi56NNhvrOc0YIfvA7D260ZRTTYh2R0CQQDq5CbO1dCo5vtbWt1sPXYMhSqTOT8owXWaw+LWIIzNbPaTjxwX7BRsfqTzxVOY89HYQEfU5IwO8oQr1BI9EUvxAkEA97yM6pTd7KKf5P6pUWE1OgWwLVc3klAiq4eBZeWaJPrfnKzYPbSSLs/30JjCqI6prLvK9w7DRxCuJY0OZgvMHQJAGdk5nBFTgQLKLmd1bm/lCcOtx73JAYcolftwfvfeBs0y5VIeWVOVe8sEA/93D6HlOdL5FKiB8TMm8FvKFgZNQQJABkahzNu0zqlyZxhamtMtoZ2aRgTDP3fRIWd9gTqSKSToQaHtrY1g2U81xOnuZMMtrNtqnguQHZvW77oTHZLTmw==";
	
	public static String partner = "2088321047262007";
	public static String seller = partner;
	// 支付宝的公钥，无需修改该值 
	public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "/usr/app/log/";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 签名方式 不需修改
	public static String sign_type = "RSA";

}
