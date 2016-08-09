/**
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.credit;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.ReferenceData;
import com.opengamma.strata.basics.currency.AdjustablePayment;
import com.opengamma.strata.product.ResolvedTrade;
import com.opengamma.strata.product.TradeInfo;

/**
 * A trade in a single-name credit default swap (CDS), resolved for pricing.
 * <p>
 * This is the resolved form of {@link CdsTrade} and is the primary input to the pricers.
 * Applications will typically create a {@code ResolvedCdsTrade} from a {@code CdsTrade}
 * using {@link CdsTrade#resolve(ReferenceData)}.
 * <p>
 * A {@code ResolvedCdsTrade} is bound to data that changes over time, such as holiday calendars.
 * If the data changes, such as the addition of a new holiday, the resolved form will not be updated.
 * Care must be taken when placing the resolved form in a cache or persistence layer.
 */
@BeanDefinition
public class ResolvedCdsTrade
    implements ResolvedTrade, ImmutableBean, Serializable {

  /**
   * The additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final TradeInfo info;
  /**
   * The CDS that was traded.
   * <p>
   * The product captures the contracted financial details of the trade.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final ResolvedCds product;
  /**
   * The upfront fee of the product.
   * <p>
   * This specifies a single amount payable by the buyer to the seller
   * Thus the sign must be compatible with the product Pay/Receive flag.
   * <p>
   * Some CDSs, especially legacy products, are traded at par and the upfront fee is not paid.
   */
  @PropertyDefinition(get = "optional")
  private final AdjustablePayment upfrontFee;

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ResolvedCdsTrade}.
   * @return the meta-bean, not null
   */
  public static ResolvedCdsTrade.Meta meta() {
    return ResolvedCdsTrade.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ResolvedCdsTrade.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ResolvedCdsTrade.Builder builder() {
    return new ResolvedCdsTrade.Builder();
  }

  /**
   * Restricted constructor.
   * @param builder  the builder to copy from, not null
   */
  protected ResolvedCdsTrade(ResolvedCdsTrade.Builder builder) {
    JodaBeanUtils.notNull(builder.info, "info");
    JodaBeanUtils.notNull(builder.product, "product");
    this.info = builder.info;
    this.product = builder.product;
    this.upfrontFee = builder.upfrontFee;
  }

  @Override
  public ResolvedCdsTrade.Meta metaBean() {
    return ResolvedCdsTrade.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   * @return the value of the property, not null
   */
  @Override
  public TradeInfo getInfo() {
    return info;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the CDS that was traded.
   * <p>
   * The product captures the contracted financial details of the trade.
   * @return the value of the property, not null
   */
  @Override
  public ResolvedCds getProduct() {
    return product;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the upfront fee of the product.
   * <p>
   * This specifies a single amount payable by the buyer to the seller
   * Thus the sign must be compatible with the product Pay/Receive flag.
   * <p>
   * Some CDSs, especially legacy products, are traded at par and the upfront fee is not paid.
   * @return the optional value of the property, not null
   */
  public Optional<AdjustablePayment> getUpfrontFee() {
    return Optional.ofNullable(upfrontFee);
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ResolvedCdsTrade other = (ResolvedCdsTrade) obj;
      return JodaBeanUtils.equal(info, other.info) &&
          JodaBeanUtils.equal(product, other.product) &&
          JodaBeanUtils.equal(upfrontFee, other.upfrontFee);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(info);
    hash = hash * 31 + JodaBeanUtils.hashCode(product);
    hash = hash * 31 + JodaBeanUtils.hashCode(upfrontFee);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("ResolvedCdsTrade{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("info").append('=').append(JodaBeanUtils.toString(info)).append(',').append(' ');
    buf.append("product").append('=').append(JodaBeanUtils.toString(product)).append(',').append(' ');
    buf.append("upfrontFee").append('=').append(JodaBeanUtils.toString(upfrontFee)).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ResolvedCdsTrade}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code info} property.
     */
    private final MetaProperty<TradeInfo> info = DirectMetaProperty.ofImmutable(
        this, "info", ResolvedCdsTrade.class, TradeInfo.class);
    /**
     * The meta-property for the {@code product} property.
     */
    private final MetaProperty<ResolvedCds> product = DirectMetaProperty.ofImmutable(
        this, "product", ResolvedCdsTrade.class, ResolvedCds.class);
    /**
     * The meta-property for the {@code upfrontFee} property.
     */
    private final MetaProperty<AdjustablePayment> upfrontFee = DirectMetaProperty.ofImmutable(
        this, "upfrontFee", ResolvedCdsTrade.class, AdjustablePayment.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "info",
        "product",
        "upfrontFee");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return info;
        case -309474065:  // product
          return product;
        case 963468344:  // upfrontFee
          return upfrontFee;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ResolvedCdsTrade.Builder builder() {
      return new ResolvedCdsTrade.Builder();
    }

    @Override
    public Class<? extends ResolvedCdsTrade> beanType() {
      return ResolvedCdsTrade.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code info} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<TradeInfo> info() {
      return info;
    }

    /**
     * The meta-property for the {@code product} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ResolvedCds> product() {
      return product;
    }

    /**
     * The meta-property for the {@code upfrontFee} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<AdjustablePayment> upfrontFee() {
      return upfrontFee;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return ((ResolvedCdsTrade) bean).getInfo();
        case -309474065:  // product
          return ((ResolvedCdsTrade) bean).getProduct();
        case 963468344:  // upfrontFee
          return ((ResolvedCdsTrade) bean).upfrontFee;
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code ResolvedCdsTrade}.
   */
  public static class Builder extends DirectFieldsBeanBuilder<ResolvedCdsTrade> {

    private TradeInfo info;
    private ResolvedCds product;
    private AdjustablePayment upfrontFee;

    /**
     * Restricted constructor.
     */
    protected Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    protected Builder(ResolvedCdsTrade beanToCopy) {
      this.info = beanToCopy.getInfo();
      this.product = beanToCopy.getProduct();
      this.upfrontFee = beanToCopy.upfrontFee;
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return info;
        case -309474065:  // product
          return product;
        case 963468344:  // upfrontFee
          return upfrontFee;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          this.info = (TradeInfo) newValue;
          break;
        case -309474065:  // product
          this.product = (ResolvedCds) newValue;
          break;
        case 963468344:  // upfrontFee
          this.upfrontFee = (AdjustablePayment) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public ResolvedCdsTrade build() {
      return new ResolvedCdsTrade(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the additional trade information, defaulted to an empty instance.
     * <p>
     * This allows additional information to be attached to the trade.
     * @param info  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder info(TradeInfo info) {
      JodaBeanUtils.notNull(info, "info");
      this.info = info;
      return this;
    }

    /**
     * Sets the CDS that was traded.
     * <p>
     * The product captures the contracted financial details of the trade.
     * @param product  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder product(ResolvedCds product) {
      JodaBeanUtils.notNull(product, "product");
      this.product = product;
      return this;
    }

    /**
     * Sets the upfront fee of the product.
     * <p>
     * This specifies a single amount payable by the buyer to the seller
     * Thus the sign must be compatible with the product Pay/Receive flag.
     * <p>
     * Some CDSs, especially legacy products, are traded at par and the upfront fee is not paid.
     * @param upfrontFee  the new value
     * @return this, for chaining, not null
     */
    public Builder upfrontFee(AdjustablePayment upfrontFee) {
      this.upfrontFee = upfrontFee;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("ResolvedCdsTrade.Builder{");
      int len = buf.length();
      toString(buf);
      if (buf.length() > len) {
        buf.setLength(buf.length() - 2);
      }
      buf.append('}');
      return buf.toString();
    }

    protected void toString(StringBuilder buf) {
      buf.append("info").append('=').append(JodaBeanUtils.toString(info)).append(',').append(' ');
      buf.append("product").append('=').append(JodaBeanUtils.toString(product)).append(',').append(' ');
      buf.append("upfrontFee").append('=').append(JodaBeanUtils.toString(upfrontFee)).append(',').append(' ');
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
