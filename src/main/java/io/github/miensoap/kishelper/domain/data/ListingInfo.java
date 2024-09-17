package io.github.miensoap.kishelper.domain.data;

public record ListingInfo(
        String listedStockNumber,
        String listingDate,
        String listingStatus,
        Boolean delisted,
        String delistedDate
) {
    public static ListingInfo of(StockDetails details) {
        return new ListingInfo(
                details.listedStockNumber(),
                details.listingDate(),
                details.listingStatus(),
                details.delisted().equals("Y"),
                details.delistedDate()
        );
    }
}
