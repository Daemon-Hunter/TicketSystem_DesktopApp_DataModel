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
    public class ArtistsController : ApiController
    {
        private Entities1 db = new Entities1();

        // GET: api/Artists
        public IQueryable<ARTIST> GetARTISTs()
        {
            return db.ARTISTs;
        }

        // GET: api/Artists/5
        [ResponseType(typeof(ARTIST))]
        public IHttpActionResult GetARTIST(int id)
        {
            ARTIST aRTIST = db.ARTISTs.Find(id);
            if (aRTIST == null)
            {
                return NotFound();
            }

            return Ok(aRTIST);
        }

        // PUT: api/Artists/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutARTIST(int id, ARTIST aRTIST)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != aRTIST.ARTIST_ID)
            {
                return BadRequest();
            }

            db.Entry(aRTIST).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ARTISTExists(id))
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

        // POST: api/Artists
        [ResponseType(typeof(ARTIST))]
        public IHttpActionResult PostARTIST(ARTIST aRTIST)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.ARTISTs.Add(aRTIST);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (ARTISTExists(aRTIST.ARTIST_ID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = aRTIST.ARTIST_ID }, aRTIST);
        }

        // DELETE: api/Artists/5
        [ResponseType(typeof(ARTIST))]
        public IHttpActionResult DeleteARTIST(int id)
        {
            ARTIST aRTIST = db.ARTISTs.Find(id);
            if (aRTIST == null)
            {
                return NotFound();
            }

            db.ARTISTs.Remove(aRTIST);
            db.SaveChanges();

            return Ok(aRTIST);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool ARTISTExists(int id)
        {
            return db.ARTISTs.Count(e => e.ARTIST_ID == id) > 0;
        }
    }
}