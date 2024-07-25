package code.otherrepo.telldontask;

class AskRemoteService {
    boolean isOperationAvaliable() {return true;}
    void doOperation() {}
}

class AskPatternClient {
    void callRemote() {

        var service = new AskRemoteService();

        if (service.isOperationAvaliable()) { // network latency here
            service.doOperation(); // network latency again
        }
    }
}

class TellRemoteService {
    private boolean isOperationAvaiable() {return true;}
    void doOperation() {
        if(isOperationAvaiable()) {
            //do something
        }
    }
}

class TellPetternClient {
    void callRemote() {
        var service = new TellRemoteService();

        service.doOperation();
    }
}