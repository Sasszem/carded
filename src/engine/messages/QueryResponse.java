/**
 * 
 */
package engine.messages;

import engine.Message;

/**
 * @author laci
 *
 */
public class QueryResponse<DataType> extends Message {

	private DataType data;
	private Integer responseId; 
	
	/**
	 * @param type
	 */
	public QueryResponse(DataType data, Integer responseId) {
		super("QueryResponse");
		this.responseId = responseId;
		this.data = data;
	}

	public DataType getData()
	{
		return this.data;
	}
	public Integer getResponseId()
	{
		return this.responseId;
	}
	
	public String toString()
	{
		return String.format("QueryResponse(responseId=%d, data=%s)", this.responseId,this.data);
	}
}
