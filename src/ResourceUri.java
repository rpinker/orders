
public class ResourceUri
{
	private boolean isHttps;
	private String ip;
	private int port;
	private String uri;
	
	public ResourceUri()
	{
	
	}

	public boolean isHttps()
	{
		return isHttps;
	}

	public void setHttps(boolean isHttps)
	{
		this.isHttps = isHttps;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public String getUri()
	{
		return uri;
	}

	public void setUri(String uri)
	{
		this.uri = uri;
	}

	@Override
	public String toString()
	{
		return "http" + ((isHttps)?"s":"") + "://" + ip + ":" + port + "/" + uri;
	}
	
	
}
