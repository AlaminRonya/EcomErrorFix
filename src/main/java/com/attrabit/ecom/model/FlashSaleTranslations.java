package com.attrabit.ecom.model;
import jakarta.persistence.*;

@Entity
@Table(name = "flash_sale_translations")
public class FlashSaleTranslations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "flash_sale_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_flash_sale_translations_flash_sale"))
    private FlashSales flashSale;

    @Column(name = "locale", nullable = false)
    private String locale;

    @Column(name = "campaign_name", nullable = false)
    private String campaignName;

    // constructors, getters, setters, etc.
}
