package com.attrabit.ecom.model;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "wish_lists")
@IdClass(WishLists.WishListId.class)
public class WishLists {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Products product;

    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    // constructors, getters, and setters

    public static class WishListId implements Serializable {
        private Long userId;
        private Long productId;

        public WishListId() {
        }

        public WishListId(Long userId, Long productId) {
            this.userId = userId;
            this.productId = productId;
        }

        // equals and hashCode methods
    }
}
