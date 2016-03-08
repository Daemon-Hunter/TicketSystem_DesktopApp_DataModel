using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using API.Models;

namespace API.Controllers
{
    public class GuestBookingsController : ApiController
    {
        private Entities6 db = new Entities6();

        // GET: api/GuestBookings
        public IQueryable<GUEST_BOOKING> GetGUEST_BOOKING()
        {
            return db.GUEST_BOOKING;
        }

        // GET: api/GuestBookings/5
        [ResponseType(typeof(GUEST_BOOKING))]
        public IHttpActionResult GetGUEST_BOOKING(int id)
        {
            GUEST_BOOKING gUEST_BOOKING = db.GUEST_BOOKING.Find(id);
            if (gUEST_BOOKING == null)
            {
                return NotFound();
            }

            return Ok(gUEST_BOOKING);
        }

        // PUT: api/GuestBookings/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutGUEST_BOOKING(int id, GUEST_BOOKING gUEST_BOOKING)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != gUEST_BOOKING.GUEST_BOOKING_ID)
            {
                return BadRequest();
            }

            db.Entry(gUEST_BOOKING).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!GUEST_BOOKINGExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/GuestBookings
        [ResponseType(typeof(GUEST_BOOKING))]
        public IHttpActionResult PostGUEST_BOOKING(GUEST_BOOKING gUEST_BOOKING)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.GUEST_BOOKING.Add(gUEST_BOOKING);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (GUEST_BOOKINGExists(gUEST_BOOKING.GUEST_BOOKING_ID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = gUEST_BOOKING.GUEST_BOOKING_ID }, gUEST_BOOKING);
        }

        // DELETE: api/GuestBookings/5
        [ResponseType(typeof(GUEST_BOOKING))]
        public IHttpActionResult DeleteGUEST_BOOKING(int id)
        {
            GUEST_BOOKING gUEST_BOOKING = db.GUEST_BOOKING.Find(id);
            if (gUEST_BOOKING == null)
            {
                return NotFound();
            }

            db.GUEST_BOOKING.Remove(gUEST_BOOKING);
            db.SaveChanges();

            return Ok(gUEST_BOOKING);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool GUEST_BOOKINGExists(int id)
        {
            return db.GUEST_BOOKING.Count(e => e.GUEST_BOOKING_ID == id) > 0;
        }
    }
}