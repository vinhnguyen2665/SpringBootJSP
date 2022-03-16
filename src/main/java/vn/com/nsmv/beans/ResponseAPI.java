package vn.com.nsmv.beans;

public class ResponseAPI<T> {
	private int status;
	private String message;

	private Integer draw = 1;
	private Integer recordsTotal = 0;
	private Integer recordsFiltered = 0;
	private T data;
	private Long dataId;

	public ResponseAPI() {
	}

	public ResponseAPI(int status, T data) {
		this.status = status;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	@Override
	public String toString() {
		return "ResponseAPI{" +
				"status=" + status +
				", message='" + message + '\'' +
				", draw=" + draw +
				", recordsTotal=" + recordsTotal +
				", recordsFiltered=" + recordsFiltered +
				", data=" + data +
				'}';
	}
}
