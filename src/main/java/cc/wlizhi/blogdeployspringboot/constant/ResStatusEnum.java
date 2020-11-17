package cc.wlizhi.blogdeployspringboot.constant;

import lombok.Getter;

/**
 * @author Eddie
 */
@Getter
public enum ResStatusEnum {
	/**
	 *
	 */
	R200(200, "成功"),
	;
	private final int code;
	private final String msg;

	ResStatusEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
