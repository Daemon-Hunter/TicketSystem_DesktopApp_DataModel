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
    public class VenueReviewsController : ApiController
    {
        private Entities12 db = new Entities12();

        // GET: api/VenueReviews
        public IQueryable<VENUE_REVIEW> GetVENUE_REVIEW()
        {
            return db.VENUE_REVIEW;
        }

        // GET: api/VenueReviews/5
        [ResponseType(typeof(VENUE_REVIEW))]
        public IHttpActionResult GetVENUE_REVIEW(int id)
        {
            VENUE_REVIEW vENUE_REVIEW = db.VENUE_REVIEW.Find(id);
            if (vENUE_REVIEW == null)
            {
                return NotFound();
            }

            return Ok(vENUE_REVIEW);
        }

        // PUT: api/VenueReviews/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutVENUE_REVIEW(int id, VENUE_REVIEW vENUE_REVIEW)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != vENUE_REVIEW.VENUE_ID)
            {
                return BadRequest();
            }

            db.Entry(vENUE_REVIEW).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!VENUE_REVIEWExists(id))
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

        // POST: api/VenueReviews
        [ResponseType(typeof(VENUE_REVIEW))]
        public IHttpActionResult PostVENUE_REVIEW(VENUE_REVIEW vENUE_REVIEW)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.VENUE_REVIEW.Add(vENUE_REVIEW);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (VENUE_REVIEWExists(vENUE_REVIEW.VENUE_ID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = vENUE_REVIEW.VENUE_ID }, vENUE_REVIEW);
        }

        // DELETE: api/VenueReviews/5
        [ResponseType(typeof(VENUE_REVIEW))]
        public IHttpActionResult DeleteVENUE_REVIEW(int id)
        {
            VENUE_REVIEW vENUE_REVIEW = db.VENUE_REVIEW.Find(id);
            if (vENUE_REVIEW == null)
            {
                return NotFound();
            }

            db.VENUE_REVIEW.Remove(vENUE_REVIEW);
            db.SaveChanges();

            return Ok(vENUE_REVIEW);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool VENUE_REVIEWExists(int id)
        {
            return db.VENUE_REVIEW.Count(e => e.VENUE_ID == id) > 0;
        }
    }
}