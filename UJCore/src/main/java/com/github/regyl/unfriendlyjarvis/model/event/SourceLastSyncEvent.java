package com.github.regyl.unfriendlyjarvis.model.event;

import com.github.regyl.unfriendlyjarvis.configuration.datetime.DateTimeSupplierFactory;
import com.github.regyl.unfriendlyjarvis.model.SourceLastSyncModel;
import org.springframework.context.ApplicationEvent;

public class SourceLastSyncEvent extends ApplicationEvent {

    public SourceLastSyncEvent(SourceLastSyncModel source) {
        super(source, DateTimeSupplierFactory.ZONE_OFFSET_CLOCK);
    }

    @Override
    public SourceLastSyncModel getSource() {
        return (SourceLastSyncModel) super.getSource();
    }
}
