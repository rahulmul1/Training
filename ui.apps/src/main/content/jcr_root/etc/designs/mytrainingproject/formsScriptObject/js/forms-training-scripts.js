function addPanels(num, repeatablePanel) {
	var iNum = Number(num);
    var im = repeatablePanel.instanceManager;
    var iCurrCount = Number(im.instanceCount);
    while (iNum > iCurrCount) {
       im.addInstance(); // add Instance checks internally for maxCount so you need not do that;
       iCurrCount++;
    } 
    while (iNum < iCurrCount) {
       im.removeInstance(iCurrCount- 1); // removeInstance checks internally for minCount
       iCurrCount--;
    }
}

