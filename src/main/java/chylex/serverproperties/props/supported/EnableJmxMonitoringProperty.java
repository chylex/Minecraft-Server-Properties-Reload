package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.util.monitoring.jmx.MinecraftServerStatistics;
import org.apache.logging.log4j.LogManager;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public final class EnableJmxMonitoringProperty extends BoolServerProperty {
	public static final EnableJmxMonitoringProperty INSTANCE = new EnableJmxMonitoringProperty();
	
	private EnableJmxMonitoringProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.enableJmxMonitoring;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setEnableJmxMonitoring(value);
		
		try {
			ManagementFactory.getPlatformMBeanServer().unregisterMBean(new ObjectName("net.minecraft.server:type=Server"));
		} catch (final MBeanRegistrationException | MalformedObjectNameException e) {
			LogManager.getLogger().warn("Failed to unregister server JMX bean", e);
		} catch (final InstanceNotFoundException e) {
			// ignore
		}
		
		if (value) {
			MinecraftServerStatistics.registerJmxMonitoring(server);
		}
	}
}
