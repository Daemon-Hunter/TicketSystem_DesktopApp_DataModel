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
    public partial class CHILD_EVENT
    {
        [Required]
        [Key]
        public int CHILD_EVENT_ID { get; set; }

        [Required]
        [ForeignKey("LINEUP_ID")]
        public Nullable<int> LINEUP_ID { get; set; }

        [Required]
        [ForeignKey("VENUE_ID")]
        public Nullable<int> VENUE_ID { get; set; }

        [Required]
        [ForeignKey("PARENT_EVENT_ID")]
        public int PARENT_EVENT_ID { get; set; }

        [Required]
        public string CHILD_EVENT_NAME { get; set; }

        [Required]
        public string CHILD_EVENT_DESCRIPTION { get; set; }

        [Required]
        public Nullable<DateTime> START_DATE_TIME { get; set; }

        [Required]
        public Nullable<DateTime> END_DATE_TIME { get; set; }

        [Required]
        public bool CHILD_EVENT_CANCELED { get; set; }
    }
}
