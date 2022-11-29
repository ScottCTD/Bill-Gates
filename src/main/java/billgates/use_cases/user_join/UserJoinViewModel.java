package billgates.use_cases.user_join;

/**
 * Clean Architecture Layer: Interface Adapters
 * A view model holding information for the GUI to display.
 *
 * @author Xinxiang
 * @see billgates.interface_adapters.UserJoinUpdatable
 * @see UserJoinPresenter
 */
public class UserJoinViewModel {

    /**
     * Whether the user is joined.
     */
    private boolean isJoined;
    /**
     * The reason that the view model is presented.
     */
    private String reasonRejected;

    public UserJoinViewModel(boolean isJoined, String reasonRejected) {
        this.isJoined = isJoined;
        this.reasonRejected = reasonRejected;
    }

    public boolean isJoined() {
        return this.isJoined;
    }

    public void setJoined(boolean joined) {
        this.isJoined = joined;
    }

    public String getReasonRejected() {
        return this.reasonRejected;
    }

    public void setReasonRejected(String reasonRejected) {
        this.reasonRejected = reasonRejected;
    }
}