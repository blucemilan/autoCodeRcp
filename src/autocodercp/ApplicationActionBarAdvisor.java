package autocodercp;
import java.util.Arrays;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.wb.swt.ActionManager;
import com.view.FirstStepView;
 
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction iExitAction;
	private IAction firstStepAction;
	private MenuManager mainMenu;
	
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		firstStepAction = new Action() {
			public void run() {
				ActionManager.createShowViewAction(Activator.getDefault().getWorkbench().getActiveWorkbenchWindow(), FirstStepView.ID).run();
			}
		};
		firstStepAction.setText("第一步");
		iExitAction = ActionFactory.QUIT.create(window);
		register(iExitAction);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		
		mainMenu = createMenuManager(mainMenu, "第一步", "mainMenu");
		addContributionItem(menuBar, mainMenu);
		mainMenu.add(firstStepAction);
		mainMenu.add(iExitAction);
	}
	
	private MenuManager createMenuManager(MenuManager menuManager, String text, String id) {
		if (menuManager == null) {
			menuManager = new MenuManager(text, id);
		}
		return menuManager;
	}

	private void addContributionItem(IMenuManager menuManager, IContributionItem item) {
		if (!Arrays.asList(menuManager.getItems()).contains(item)) {
			menuManager.add(item);
		}
	}
}
