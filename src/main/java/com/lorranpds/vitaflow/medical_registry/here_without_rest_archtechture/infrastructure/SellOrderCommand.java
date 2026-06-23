package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtechture.infrastructure;

// 3. Os Concrete Commands
public class SellOrderCommand implements OrderCommand {
    private final MarketEngine engine;
    private final String ticker;
    private final int quantity;

    public SellOrderCommand(MarketEngine engine, String ticker, int quantity) {
        this.engine = engine;
        this.ticker = ticker;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        engine.executeSell(ticker, quantity);
    }
}
