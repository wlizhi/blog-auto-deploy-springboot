package cc.wlizhi.blogdeployspringboot.model;

import cc.wlizhi.blogdeployspringboot.constant.ResStatusEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eddie
 */
@Getter
@Setter
public class ResModel<T> {
	private Integer code;
	private String msg;
	private T data;

	public ResModel(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> ResModel<T> response(int code, String msg, T data) {
		return new ResModel<>(code, msg, data);
	}

	public static <T> ResModel<T> response(int code, String msg) {
		return response(code, msg, null);
	}

	public static <T> ResModel<T> response(ResStatusEnum statusEnum) {
		return response(statusEnum, null);
	}

	public static <T> ResModel<T> response(ResStatusEnum statusEnum, T data) {
		return response(statusEnum.getCode(), statusEnum.getMsg(), data);
	}
}
