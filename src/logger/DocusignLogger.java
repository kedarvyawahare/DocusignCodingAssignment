package logger;

// custom logger

class DocusignLogger {


	private static volatile DocusignLogger logger=null;

	private DocusignLogger() {
	}


	public static DocusignLogger getinstance()
	{
		if(logger==null)
		{
			synchronized (DocusignLogger.class)

			{
				if(logger==null)
					logger=new DocusignLogger();
			}
		}		
		return logger;

	}

	public void info(String msg)

	{
		System.out.println(msg);

	}

	public void error(String msg)

	{
		System.err.println(msg);

	}

	public void warn(String msg)

	{
		System.err.print("warn :" +msg);

	}

}

