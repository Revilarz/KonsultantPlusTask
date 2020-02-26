package steps;

import pageObjects.SearchResultPage;
import io.qameta.allure.Step;

public class SearchResultsPageSteps {
    private SearchResultPage objSRP = new SearchResultPage();

    @Step("Нажатие на первый элмент результатов поиска")
    public void clickFirstRow(){
        objSRP = new SearchResultPage();
        objSRP.clickFirstRow();
    }
}
