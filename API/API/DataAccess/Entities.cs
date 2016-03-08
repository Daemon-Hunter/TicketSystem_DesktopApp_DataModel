using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using API.Models;

namespace API.DataAccess
{
    public class Entities : DbContext
    {
        DbSet<CUSTOMER>      Customers      { get; set; }
        DbSet<ARTIST>        Artists        { get; set; }
        DbSet<ARTIST_REVIEW> ArtistReviews  { get; set; }
        DbSet<BOOKING>       Bookings       { get; set; }
        DbSet<CHILD_EVENT>   ChildEvents    { get; set; }
        DbSet<EVENT_REVIEW>  EventReviews   { get; set; }
        DbSet<GUEST_BOOKING> GuestBookings  { get; set; }
        DbSet<LINEUP>        Lineups        { get; set; }
        DbSet<PARENT_EVENT>  ParentEvents   { get; set; }
        DbSet<SOCIAL_MEDIA>  SocialMedias   { get; set; }
        DbSet<TICKET>        Tickets        { get; set; }
        DbSet<VENUE>         Venues         { get; set; }
        DbSet<VENUE_REVIEW>  VenueReviews   { get; set; }
    }
}