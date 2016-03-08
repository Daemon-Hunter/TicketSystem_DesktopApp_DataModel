//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace API.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    public partial class VENUE_REVIEW
    {
        [Required]
        [Key]
        public int VENUE_ID { get; set; }

        [Required]
        [ForeignKey("CUSTOMER_ID")]
        public int CUSTOMER_ID { get; set; }

        [Required]
        public decimal VENUE_REVIEW_RATING { get; set; }

        [Required]
        public string VENUE_REVIEW_BODY { get; set; }

        [Required]
        public DateTime VENUE_REVIEW_DATE_TIME { get; set; }

        [Required]
        public bool VENUE_REVIEW_VERIFIED { get; set; }
    }
}
