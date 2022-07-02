<<<<<<< HEAD
package com.example.springcloudprovider8081.common;

public class ResultCode {

    /**
     * 成功状态码
     */
    public static final Integer SUCCESS = 200;
    /*** 失败状态码 */
    public static final Integer ERROR = 500;
    /*** 未登录状态码 */
    public static final int NO_LOGIN = 600;
    /*** 没有权限状态码 */
    public static final int NO_AUTH = 700;

    private ResultCode() {
        throw new IllegalStateException("Utility class");
    }
}
=======
package com.example.springcloudprovider8081.common;

public class ResultCode {

    /**
     * 成功状态码
     */
    public static final Integer SUCCESS = 200;
    /*** 失败状态码 */
    public static final Integer ERROR = 500;
    /*** 未登录状态码 */
    public static final int NO_LOGIN = 600;
    /*** 没有权限状态码 */
    public static final int NO_AUTH = 700;

    private ResultCode() {
        throw new IllegalStateException("Utility class");
    }
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
