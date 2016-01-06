package ligapilkarska;

/**
 *
 * @author Kamil Pek [231050]
 * @since 27.12.2015
 * @version 1.3 Last update: 06.01.2015, 14:10
 */
public class LigaPilkarska {

    public static void main(String[] args){

        model model = new model();
        view view = new view(model);
        controller controller = new controller(model, view);

    }

}
