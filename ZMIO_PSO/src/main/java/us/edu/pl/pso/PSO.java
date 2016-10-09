package us.edu.pl.pso;

/**
 * Hello world!
 *
 */
public class PSO 
{
    public static void main( String[] args )
    {
    	PSOView view = new PSOView();
        PSOModel model = new PSOModel();
        
        PSOController controller = new PSOController(view, model);
    }
}
