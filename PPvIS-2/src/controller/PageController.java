package controller;


public class PageController {

	int page=0;
	
	public int getPage()
	{
	    return page;
	}
	
	public void firsPage()
	{
		page=0;
	}

    public void nextPage(Controller controller)
    {
        if(page< controller.getTable().size()/10)    
        {
            page++;
        }
        
    }

    public void previousPage()
    {
        if(page>0)
            page--;
    }

    public void lastPage(Controller controller)
    {
        if(controller.getTable().size()%10==0)
        {
            page = controller.getTable().size() / 10 - 1;
        }
        else
        {
            page = controller.getTable().size() / 10;
        }
    }

}
