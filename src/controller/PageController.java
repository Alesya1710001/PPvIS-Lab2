package controller;

public class PageController 
{
	private int page=0;
	private int numberOfElement=10;
	
	public void setNumberOfELement(int number)
	{
		numberOfElement= number;
	}
	
	public int getNumberOfELement()
	{
		return numberOfElement;
	}
	
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
        if(page< controller.getTable().size()/ numberOfElement)    
            page++;
    }

    public void previousPage()
    {
        if(page>0)
            page--;
    }

    public void lastPage(Controller controller)
    {
        if(controller.getTable().size()% numberOfElement==0)
        {
            page = controller.getTable().size() /  numberOfElement - 1;
        }
        else
        {
            page = controller.getTable().size() /  numberOfElement;
        }
    }

}
