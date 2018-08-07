/**
 * 
 */
package engine.messages;

import engine.Message;

/**
 * @author laci
 *
 */
public class DataQuery extends Message {

	private Integer id;
	private static Integer lastId=0;
	
	public String url;
	
	/**
	 * @param type
	 */
	public DataQuery(String url) {
		super("DataQuery");
		this.url = url;
		this.id = DataQuery.lastId++;
	}

	public int getId()
	{
		return this.id;
	}
	
	public String toString()
	{
		return String.format("DataQuery(url=\"%s\", id=%d)", this.url, this.id);
	}
}
